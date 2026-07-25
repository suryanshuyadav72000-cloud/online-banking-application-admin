const { getDB } = require('./db');

module.exports = async function handler(req, res) {
  let body = req.body || {};
  if (typeof body === 'string') {
    const querystring = require('querystring');
    body = querystring.parse(body);
  }

  const account = body.account || req.query.account;
  const db = getDB();

  const customer = db.customers.find(c => c.account === account);

  res.setHeader('Content-Type', 'text/html; charset=utf-8');
  let html = `<!DOCTYPE html><html><head><title>Check Balance</title><link rel="stylesheet" href="/css/style.css"></head><body><div class="container">`;

  if (customer) {
    html += `<h2>Current Balance: ₹ ${customer.balance.toFixed(2)}</h2>`;
  } else {
    html += `<h2>Account Number Not Found!</h2>`;
  }

  html += `<br><a href="/AdminDashboard.html">Back to Dashboard</a></div></body></html>`;

  return res.status(200).send(html);
};
