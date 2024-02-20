
async function fetchFromServer_Servlet(){
    var child = document.createElement('div');

    const resultFromServer = await fetch('http://localhost:8080/socketTest/test-servlet');
    const textFromServer= await resultFromServer.text();

    child.innerHTML = textFromServer;
    child = child.firstChild;
    document.getElementById('servlet-example-answer').appendChild(child);
}

