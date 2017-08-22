
const net = require("net");

const sum = (data) => {

    let HOST = 10997;
    let PORT = "localhost";

    const client = new net.Socket();

    client.connect(PORT, HOST, () => {
        console.log("> Socket aberto... \nEnviar a requisição \n");
        client.write(JSON.stringify(data));
    });

    client.on("close", () => {
	    console.log('Connection closed');
    });
}

module.exports = sum;
