function checkWordExistence() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("ResultText").innerHTML = this.responseText;
        }
    };
    xhttp.open("POST", "/search", true);
    var word = document.getElementById("wordInputBox").value;
    xhttp.send("word=" + word);
}