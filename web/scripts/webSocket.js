const socket = new WebSocket("ws://localhost:8080/socketTest/websocket-test");

async function fetchFromServer_Socket(){
    socket.addEventListener("message", (event) => {
        document.getElementById('socket-example-answer').innerHTML=event.data;
    });
}

async function askQuestion(){
    socket.send({"subject":"ss","content":"yy"});
}
