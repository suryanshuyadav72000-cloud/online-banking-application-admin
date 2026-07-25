const { getDB, saveDB } = require('./db');

module.exports = async function handler(req, res) {
  if (req.method !== 'POST') {
    return res.status(405).json({ error: 'Method not allowed' });
  }

  let body = req.body || {};
  if (typeof body === 'string') {
    const querystring = require('querystring');
    body = querystring.parse(body);
  }

  const { fullname, username, email, password, mobile } = body;
  const db = getDB();

  db.users.push({ fullname, username, email, password, mobile, createdAt: new Date() });
  saveDB(db);

  res.setHeader('Content-Type', 'text/html; charset=utf-8');
  return res.status(200).send(`
    <div style="font-family: Arial; text-align: center; margin-top: 50px;">
      <h2>Registration Successful!</h2>
      <a href="/login.html">Click here to Login</a>
    </div>
  `);
};
