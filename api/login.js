const { getDB } = require('./db');

module.exports = async function handler(req, res) {
  if (req.method !== 'POST') {
    return res.status(405).json({ error: 'Method not allowed' });
  }

  let body = req.body || {};
  if (typeof body === 'string') {
    const querystring = require('querystring');
    body = querystring.parse(body);
  }

  const { username, password } = body;
  const db = getDB();

  if (username === db.admin.username && password === db.admin.password) {
    // If request accepts html or form submission redirect to dashboard
    const accept = req.headers['accept'] || '';
    if (accept.includes('text/html') || req.headers['content-type']?.includes('application/x-www-form-urlencoded')) {
      res.writeHead(302, { Location: '/AdminDashboard.html' });
      return res.end();
    }
    return res.status(200).json({ success: true, redirect: '/AdminDashboard.html' });
  } else {
    res.setHeader('Content-Type', 'text/html; charset=utf-8');
    return res.status(401).send(`
      <h2>Invalid Username or Password</h2>
      <br><a href="/login.html">Try Again</a>
    `);
  }
};
