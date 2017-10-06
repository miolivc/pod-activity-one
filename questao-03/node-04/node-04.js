
const net = require("net");

let PORT_SERVER = 10999;
let HOST_SERVER = "localhost";

const server = net.createServer((socket) => {
	console.log("One connection has established!");

	const resp; 

    socket.on("data", data => {
		data = JSON.parse(data);
		if (data.action == "sum") {
           resp = data.y + data.x;
        } else {
            resp = data.y - data.x;
        }
		console.log("A acao foi: " + data.action + "\nA resposta foi: " + resp);
	});

}).listen(PORT_SERVER, HOST_SERVER);
