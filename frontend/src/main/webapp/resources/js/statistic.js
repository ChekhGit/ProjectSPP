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
//     /*controlsArray.forEach((elem, i) => {
//         for (let )
//         elem.forEach((con, j) =>{
//             if (con.getAttribute('id') === control.getAttribute('id')) {
//                 tabIndex = i;
//                 selectIndex = j;
//             }
//         })
//     });*/
//
//     for (let i = selectIndex; i < controlsArray[tabIndex].length; i++) {
//         $(controlsArray[tabIndex][i]).prop('disabled', false);
//         $(controlsArray[tabIndex][i]).selectpicker('refresh');
//     }
//     /*let selectCountry = document.getElementById('league-player');
//     let parent = $(selectCountry).closest('#select-container');
//     let selectArray = $(parent[0]).children('.selectpicker');
//     for (let i = 0; i< selectArray.length;i++){
//         $(selectArray[i]).prop('disabled',false);
//     }
//     // $(selectCountry).prop('disabled',false);
//     $(selectCountry).selectpicker('refresh');*/
// }

function clearSelectBox(control) {
    control.removeChild(control.childNodes[0]);
    while (control.childNodes[1]) {
        control.removeChild(control.childNodes[1]);
    }
    $(control).selectpicker('refresh');
}

function clearAll(event) {
    let button = event.target;
    let tabIndex = button.getAttribute('tab-numb');
    for (let i = 1; i < controlsArray[tabIndex].length; i++) {
        clearSelectBox(controlsArray[tabIndex][i]);
    }
}