const { getDB, saveDB } = require('./db');

module.exports = async function handler(req, res) {
  const db = getDB();

  // GET: Fetch all customers
  if (req.method === 'GET') {
    return res.status(200).json(db.customers);
  }

  // Handle Form or JSON bodies
  let body = req.body || {};
  if (typeof body === 'string') {
    const querystring = require('querystring');
    body = querystring.parse(body);
  }

  const action = req.query.action || body.action || req.method;

  // ADD CUSTOMER (POST)
  if (action === 'POST' || action === 'add') {
    const { name, account, mobile, balance } = body;
    const newId = db.customers.length > 0 ? Math.max(...db.customers.map(c => c.id)) + 1 : 101;
    const newCustomer = {
      id: newId,
      name: name || '',
      account: account || '',
      mobile: mobile || '',
      balance: parseFloat(balance) || 0.0
    };
    db.customers.push(newCustomer);
    saveDB(db);

    res.writeHead(302, { Location: '/AdminDashboard.html' });
    return res.end();
  }

  // UPDATE CUSTOMER
  if (action === 'PUT' || action === 'update') {
    const { account, name, mobile, balance } = body;
    const index = db.customers.findIndex(c => c.account === account);
    if (index !== -1) {
      if (name) db.customers[index].name = name;
      if (mobile) db.customers[index].mobile = mobile;
      if (balance !== undefined) db.customers[index].balance = parseFloat(balance);
      saveDB(db);
    }

    res.writeHead(302, { Location: '/AdminDashboard.html' });
    return res.end();
  }

  // DELETE CUSTOMER
  if (action === 'DELETE' || action === 'delete') {
    const account = body.account || req.query.account;
    db.customers = db.customers.filter(c => c.account !== account);
    saveDB(db);

    res.writeHead(302, { Location: '/AdminDashboard.html' });
    return res.end();
  }

  return res.status(400).json({ error: 'Invalid action' });
};
