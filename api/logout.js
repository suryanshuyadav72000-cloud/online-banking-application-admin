module.exports = async function handler(req, res) {
  res.writeHead(302, { Location: '/index.html' });
  return res.end();
};
