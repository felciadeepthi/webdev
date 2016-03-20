var express = require('express');
var morgan = require('morgan');
var bodyParser = require('body-parser');

var app = express();

app.use(morgan('dev'));

var hostname = 'localhost';
var port = 3000;

var dishesRouter = require('./dishRouter');
var promotionsRouter = require('./promoRouter');
var leadersRouter = require('./leaderRouter');

app.use('/dishes', dishesRouter);
app.use('/promotions', promotionsRouter);
app.use('/:leaders', leadersRouter);

app.listen(port, hostname, function () {
  console.log(`Server running at http://${hostname}:${port}/`);
});