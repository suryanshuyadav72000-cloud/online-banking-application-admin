const http = require('http');
const fs = require('fs');
const path = require('path');
const url = require('url');

const PORT = process.env.PORT || 3000;

const mimeTypes = {
  '.html': 'text/html',
  '.css': 'text/css',
  '.js': 'text/javascript',
  '.json': 'application/json',
  '.png': 'image/png',
  '.jpg': 'image/jpeg'
};

const server = http.createServer((req, res) => {
  const parsedUrl = url.parse(req.url, true);
  let pathname = parsedUrl.pathname;

  if (pathname === '/') pathname = '/index.html';

  // API Routes
  if (pathname.startsWith('/api/')) {
    const apiName = pathname.replace('/api/', '').split('?')[0];
    const apiPath = path.join(__dirname, 'api', `${apiName}.js`);
    if (fs.existsSync(apiPath)) {
      // parse body for POST/PUT requests
      let bodyData = '';
      req.on('data', chunk => { bodyData += chunk.toString(); });
      req.on('end', () => {
        req.body = bodyData;
        req.query = parsedUrl.query;
        try {
          const handler = require(apiPath);
          return handler(req, res);
        } catch (err) {
          console.error(err);
          res.writeHead(500, { 'Content-Type': 'text/plain' });
          res.end('Server Error: ' + err.message);
        }
      });
      return;
    }
  }

  // Static File Routes
  let filePath = path.join(__dirname, 'public', pathname);
  const ext = path.extname(filePath).toLowerCase();
  const contentType = mimeTypes[ext] || 'text/html';

  fs.readFile(filePath, (err, content) => {
    if (err) {
      if (err.code === 'ENOENT') {
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.end('<h1>404 Not Found</h1>');
      } else {
        res.writeHead(500);
        res.end('Server Error: ' + err.code);
      }
    } else {
      res.writeHead(200, { 'Content-Type': contentType });
      res.end(content, 'utf-8');
    }
  });
});

server.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
