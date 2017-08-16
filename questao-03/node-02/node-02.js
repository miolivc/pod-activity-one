
const net = require("net");
const processSum = require("./processSum");
const processDiff = require("./processDiff");

let PORT_SERVER = 10997;
let HOST_SERVER = "localhost";

const server = net.createServer((socket) => {
	console.log("One connection has established!");

    socket.on("data", data => {
		console.log("The Client sended: " + data);
        if (data.action == "sum") {
            processSum.sum(data);
        } else {
            processDiff.diff(data);
        }
	});

}).listen(PORT_SERVER, HOST_SERVER);
