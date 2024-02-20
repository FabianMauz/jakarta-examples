
async function fetchFromServer_Rest(){
    var child = document.createElement('div');

    const resultFromServer = await fetch('http://localhost:8080/socketTest/api/rest');
    const textFromServer= await resultFromServer.text();

    child.innerHTML = textFromServer;
    child = child.firstChild;
    document.getElementById('rest-example-answer').appendChild(child);
}
