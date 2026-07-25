const { getDB, saveDB } = require('./db');

module.exports = async function handler(req, res) {
  let body = req.body || {};
  if (typeof body === 'string') {
    const querystring = require('querystring');
    body = querystring.parse(body);
  }

  const account = body.account;
  const amount = parseFloat(body.amount) || 0;
  const db = getDB();

  const customer = db.customers.find(c => c.account === account);

  res.setHeader('Content-Type', 'text/html; charset=utf-8');
  let html = `<!DOCTYPE html><html><head><title>Withdraw</title><link rel="stylesheet" href="/css/style.css"></head><body><div class="container">`;

  if (customer && customer.balance >= amount && amount > 0) {
    customer.balance -= amount;
    saveDB(db);
    html += `<h2>Amount Withdrawn Successfully!</h2><p>Remaining Balance: ₹ ${customer.balance.toFixed(2)}</p>`;
  } else {
    html += `<h2>Insufficient Balance or Invalid Account Number!</h2>`;
  }

  html += `<br><a href="/AdminDashboard.html">Back to Dashboard</a></div></body></html>`;

  return res.status(200).send(html);
};
