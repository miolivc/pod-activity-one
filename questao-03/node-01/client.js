const rl = require("readline");
const net = require("net");

const ui = rl.createInterface(process.stdin, process.stdout);

ui.question("> Insert the required option:", (action) => {
    let x = Math.random(100);
    console.log("First number" + x);

    let y = Math.random(100);
    console.log("Second number" + y);

    ui.close();

    let request = {"action": action, "x" : x, "y" : y};

    // Depois tem que ser aleatorio para node2 ou node3
    let PORT = 10997;
    let HOST = "localhost";

    const client = new net.Socket();
    client.connect(PORT, HOST, () => {
        console.log("> Socket aberto... \nEnviar a requisição \n");
        client.write(JSON.stringify(request));
    });

    client.on("close", () => {
	    console.log('Connection closed');
    });
});
