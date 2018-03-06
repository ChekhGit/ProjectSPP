let controlsArray = [];
window.onload = function () {
    initControlsArray();
    dataOrganizer = new DataOrganizer();
    dataOrganizer.appendTable(0);
    setOnSelectHandler();
    setOnClickForClearAllButtons();
    setTabClickHandler();
    setaAddButtonHandlers();
    setCloseEventOnModalWindow();

    let button = document.getElementById('openPlayerAddModal');
    button.addEventListener('click', function (e) {
        dataOrganizer.getPositions();
    })
};

function setCloseEventOnModalWindow(){
    let modals = document.getElementsByClassName('modal');
    for (let modal of modals) {
        $('#'+modal.getAttribute('id')).on('hidden.bs.modal', function (e) {
            $('input').val('');
        });
    }
}

function setaAddButtonHandlers() {
    let buttons = document.getElementsByClassName('add');
    for (let button of buttons) {
        button.addEventListener('click', function (event) {
            let currenBut = event.currentTarget;
            let index = currenBut.getAttribute('number');
            dataOrganizer.addData(index);
        })
    }
}

function setTabClickHandler() {
    let tabs = document.getElementsByClassName('tab');
    for (let tab of tabs) {
        if (tab.getAttribute('number') === '0') {
            tab.addEventListener('click', function (event) {
                clearTable(0);
                dataOrganizer.appendTable(0);
            })
        } else {
            tab.addEventListener('click', function (event) {
                let currentTab = event.currentTarget;
                let index = currentTab.getAttribute('number');
                if (index > 0) {
                    let clearButton = document.getElementsByClassName('clear')[index - 1];
                    let clearEvent = new Event('click');
                    clearButton.dispatchEvent(clearEvent);
                    clearSelectBox(controlsArray[index][0]);
                    dataOrganizer.getData(controlsArray[index][0], 0);
                }
            })
        }
    }
}

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
        if (i !== selects.length-1)
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
    clearTable(tabIndex);
    if (controlsArray[tabIndex][selectIndex+1]) {

        for (let i = selectIndex+1; i < controlsArray[tabIndex].length; i++) {
            clearSelectBox(controlsArray[tabIndex][i]);
            if (i > selectIndex+1) {
                $(controlsArray[tabIndex][i]).prop('disabled', true);
            } else {
                $(controlsArray[tabIndex][i]).prop('disabled', false);
            }
            $(controlsArray[tabIndex][i]).selectpicker('refresh');
        }
        let prKey = $(control).val();
        dataOrganizer.getDataById(controlsArray[tabIndex][selectIndex+1], prKey);
        changeAddButtonEnable(tabIndex,true);
        let button = document.getElementsByClassName('genDoc')[tabIndex];
        $(button).prop('disabled', true);
    } else {
        let prKey = $(control).val();
        dataOrganizer.appendTable(tabIndex, prKey);
        changeAddButtonEnable(tabIndex,false);
        let button = document.getElementsByClassName('genDoc')[tabIndex];
        $(button).prop('disabled', false);
    }
}
function changeAddButtonEnable(tabIndex, flag) {
    let addButton = document.getElementsByClassName('tab-add')[tabIndex];
    $(addButton).prop('disabled', flag);
}

function clearTable(tabIndex) {
    let table = document.getElementsByClassName('info-table')[tabIndex];
    let tbody = table.getElementsByTagName('tbody')[0];
    tbody.innerHTML = '';
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
    clearTable(tabIndex);
    changeAddButtonEnable(tabIndex,true);
    let genDocButton = document.getElementsByClassName('genDoc')[tabIndex];
    $(genDocButton).prop('disabled', true);
}