
const net = require("net");

const sum = (data) => {
    let HOST = 10999;
    let PORT = "localhost";

    const client = new net.Socket();

    client.connect(PORT, HOST, () => {
        console.log("> Socket aberto... \nEnviar a requisição \n");
        client.write(JSON.stringify(data));
        // client.write(JSON.stringify({"action": data.action, "response": (data.y + data.x)}));
    });

    client.on("close", () => {
	    console.log('Connection closed');
    });
}

module.exports = sum;
