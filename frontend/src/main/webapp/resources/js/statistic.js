let controlsArray = [];
window.onload = function () {
    initControlsArray();
    dataOrganizer = new DataOrganizer();
    dataOrganizer.getData(controlsArray[0][0], 0);
    dataOrganizer.getData(controlsArray[1][0], 0);
    setOnSelectHandler();
    setOnClickForClearAllButtons();
};

function initControlsArray(){
    let tempArray = document.getElementsByClassName('tab-2');
    for (let i = 0; i < tempArray.length; i++) {
        let selectArray = tempArray[i].getElementsByTagName('select');
        controlsArray.push(selectArray);
    }
}

function setOnClickForClearAllButtons() {
    let tempArray = document.querySelectorAll('.clear');
    for (let i = 0; i < tempArray.length; i++) {
        tempArray[i].addEventListener('click', clearAll);
    }
}

function setOnSelectHandler(){
    let selects = document.getElementsByTagName('select');
    for (let i = 0; i < selects.length; i++) {
        $(selects[i]).on('changed.bs.select',onSelectHandler)
    }
}

function onSelectHandler(event) {
    let control = event.currentTarget;
    let tabIndex, selectIndex;

    for (let i = 0; i < controlsArray.length; i++) {
        for (let j = 0; j < controlsArray[i].length; j++) {
            if (controlsArray[i][j] === control){
                tabIndex = i;
                selectIndex = j;
            }
        }
    }
    if (controlsArray[tabIndex][selectIndex+1]) {
        let prKey = $(control).val();
            clearInfoBox(tabIndex);
            for (let i = selectIndex + 1; i < controlsArray[tabIndex].length; i++) {
                clearSelectBox(controlsArray[tabIndex][i]);
                if (i > selectIndex + 1) {
                    $(controlsArray[tabIndex][i]).prop('disabled', true);
                } else {
                    $(controlsArray[tabIndex][i]).prop('disabled', false);
                }
                $(controlsArray[tabIndex][i]).selectpicker('refresh');
            }

            dataOrganizer.getDataById(controlsArray[tabIndex][selectIndex + 1], prKey);
    } else {
        let prKey = $(control).val();
            if (tabIndex === 0) {
                dataOrganizer.getData(null, 4, prKey);
            } else {
                dataOrganizer.getData(null, 5, prKey);
            }
    }
}

function updateBadge(control, value) {
    let labelContainer = $(control).parent().prev();
    labelContainer[0].getElementsByClassName('badge')[0].innerHTML = value;
}

function clearSelectBox(control) {
    if (control.childNodes.length) {
            while (control.children[1]) {
                control.removeChild(control.children[1]);
            }
    }
    updateBadge(control,'');
}

function clearInfoBox(tabIndex){
    let infoBox = document.getElementsByClassName('info-box')[tabIndex];
    let spans = infoBox.getElementsByTagName('span');
    let isName = true;
    for (let elem of spans) {
        elem.innerHTML = isName ? ' ' : '';
        isName = false;
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
    clearInfoBox(tabIndex);
}
