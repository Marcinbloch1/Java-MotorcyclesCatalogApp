function load(searchedText, tableMotorcycles, motorcyclesComboBox, historyList){
    getTable(searchedText, tableMotorcycles, motorcyclesComboBox);
    getHistory(historyList);
}

function getTable(searchedText, tableId, motorcyclesComboBox) {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
    };
    
    var arg1 = document.getElementById(motorcyclesComboBox).value;
    var arg2 = document.getElementById(searchedText).value;
    
    xhttp.open("GET", "motorcycles?searchedText=" + arg2 + "&motorcyclesComboBox=" + arg1, true);
    xhttp.send();
}

function getHistory(historyList) {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            document.getElementById(historyList).innerHTML = this.responseText;
        }
    };
    
    xhttp.open("GET", "history", true);
    xhttp.send();
}