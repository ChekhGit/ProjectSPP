$.ajax({
    url: '/player',
    method: 'GET',
    success: function (data) {
        let selectCountry = document.getElementById('country-player');
        for (let country of data) {
            var newOption = document.createElement('option');
            newOption.innerHTML = country['surname'];
            selectCountry.appendChild(newOption);
        }
        $('.selectpicker').selectpicker('refresh');
    }
});
/*
function setOnSelectHandler(){
    let selects = document.getElementsByTagName('select');
    for (let select of selects) {
        select.addEventListener('select', function (evt) {
            let currentSelect = evt.target;

        })
    }
}
function clearAll(event) {
    let container = document.getElementById('select-container');
    let selectArray = container.getElementsByTagName('select');
    for (let select of selectArray) {


    }
}*/