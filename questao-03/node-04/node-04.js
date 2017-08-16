
const net = require("net");

let PORT_SERVER = 10999;
let HOST_SERVER = "localhost";

const server = net.createServer((socket) => {
	console.log("One connection has established!");

    socket.on("data", data => {
		console.log("A acao foi: " + data.action + "\nA resposta foi: " + data.response);
	});

}).listen(PORT_SERVER, HOST_SERVER);
