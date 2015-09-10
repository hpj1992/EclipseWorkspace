/**
 * Add Now.js
 */
var nowjs = require('now');
var everyone = nowjs.initialize(httpServer);

/**
 * Receive incoming messages and distribute them
 */
everyone.now.sendMessage = function(message) {
  everyone.now.receiveMessage(message);
}