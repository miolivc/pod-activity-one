const rl = require("readline");
const net = require("net");

const ui = rl.createInterface(process.stdin, process.stdout);

let x = ui.question("> Insert the first number: ");
let y = ui.question("> Insert the second number: ");

ui.question("> Insert the required option:", (action) => {
    let request = {"action": action, "x" : x, "y" : y};

    // Depois tem que ser aleatorio para node2 ou node3
    let PORT = 10997;
    let HOST = "localhost";

    const client = new net.Socket();
    client.connect(PORT, HOST, () => {
        console.log("> Socket aberto... \nEnviar a requisição \n");
        client.write(request);
    });

    client.on("close", () => {
	    console.log('Connection closed');
    });
});
