let controlsArray = [];
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
        //setOnSelectHandler();
        setOnClickForClearAllButtons();
        initControlsArray();
    }
});
function initControlsArray(){
    let tempArray = document.getElementsByClassName('tab-2');
    for (let i = 0; i < tempArray.length; i++) {
        let selectArray = tempArray[i].getElementsByTagName('select');
        controlsArray.push(selectArray);
    }
}
function setOnClickForClearAllButtons() {
    let tempArray = document.querySelectorAll('#clear');
    for (let i = 0; i < tempArray.length; i++) {
        tempArray[i].addEventListener('click', clearAll);
    }
}
// function setOnSelectHandler(){
//     let selects = document.getElementsByTagName('select');
//     for (let i = 0; i < selects.length; i++) {
//         $(selects[i]).on('changed.bs.select',onSelectHandler)
//     }
// }
//
// function onSelectHandler(event) {
//     let control = event.currentTarget;
//     let tabIndex, selectIndex;
//
//     for (let i = 0; i < controlsArray.length; i++) {
//         for (let j = 0; j < controlsArray[i].length; j++) {
//             if (controlsArray[i][j].getAttribute('id') === control.id){
//                 tabIndex = i;
//                 selectIndex = j;
//             }
//         }
//     }
//     if (controlsArray[tabIndex][selectIndex+1]) {
//         $(controlsArray[tabIndex][selectIndex+1]).prop('disabled', false);
//         $(controlsArray[tabIndex][selectIndex+1]).selectpicker('refresh');
//     }
// }

function clearSelectBox(control) {
    if (control.childNodes.length) {
        if (control.childNodes[0].localName !== 'option') {
            control.removeChild(control.childNodes[0]);
            while (control.childNodes[1]) {
                control.removeChild(control.childNodes[1]);
            }
        }
    }
}

function clearAll(event) {
    let button = event.target;
    let tabIndex = button.getAttribute('tab-numb');
    $(controlsArray[tabIndex][0]).selectpicker('val','');
    $(controlsArray[tabIndex][0]).selectpicker('refresh');
    for (let i = 1; i < controlsArray[tabIndex].length; i++) {
        clearSelectBox(controlsArray[tabIndex][i]);
        $(controlsArray[tabIndex][i]).prop('disabled', true);
        $(controlsArray[tabIndex][i]).selectpicker('refresh');
    }
}