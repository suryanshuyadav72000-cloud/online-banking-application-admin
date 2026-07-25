const fs = require('fs');
const path = require('path');

const DB_FILE = process.env.VERCEL ? '/tmp/bankdb.json' : path.join(__dirname, 'bankdb.json');

const defaultData = {
  admin: { username: "admin", password: "1234" },
  users: [],
  customers: [
    { id: 101, name: "Rahul Sharma", account: "1001", mobile: "9876543210", balance: 5000.00 },
    { id: 102, name: "Priya Patel", account: "1002", mobile: "9876543211", balance: 12500.50 },
    { id: 103, name: "Amit Kumar", account: "1003", mobile: "9876543212", balance: 7500.00 }
  ]
};

function readDB() {
  try {
    if (fs.existsSync(DB_FILE)) {
      const content = fs.readFileSync(DB_FILE, 'utf8');
      return JSON.parse(content);
    }
  } catch (e) {
    console.error("DB Read Error:", e);
  }
  writeDB(defaultData);
  return defaultData;
}

function writeDB(data) {
  try {
    fs.writeFileSync(DB_FILE, JSON.stringify(data, null, 2), 'utf8');
  } catch (e) {
    console.error("DB Write Error:", e);
  }
}

module.exports = {
  getDB: readDB,
  saveDB: writeDB
};
