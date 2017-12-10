const express = require('express');
const app = require('./app.js');
const server = express();

server.use('/graphql', app);
server.listen(4000);

console.log('Running a GraphQL API server at localhost:4000/graphql');