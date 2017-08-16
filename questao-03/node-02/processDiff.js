
const net = require("net");

const diff = (data) => {

    let HOST = 10998;
    let PORT = "localhost";

    const client = new net.Socket();

    client.connect(PORT, HOST, () => {
        console.log("> Socket aberto... \nEnviar a requisição \n");
        client.write(data);
    });

    client.on('close', () => {
	    console.log('Connection closed');
    });
}

module.exports = diff;
