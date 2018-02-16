let controlsArray = [];
let dataOrganizer;
window.onload = function () {
    initControlsArray();
    dataOrganizer = new DataOrganizer();
    dataOrganizer.getData(controlsArray[0][0], 0);
    dataOrganizer.getData(controlsArray[1][0], 0);
    setOnSelectHandler();
    setOnClickForClearAllButtons();
};
/*$.ajax({
    url: '/player',
    method: 'GET',
    success: function (data) {
        let selectCountry = document.getElementById('country-player');
        for (let country of data) {
            let newOption = document.createElement('option');
            newOption.innerHTML = country['surname'];
            selectCountry.appendChild(newOption);
        }
        let selectCountry1 = document.getElementById('country-coach');
        for (let country of data) {
            let newOption = document.createElement('option');
            newOption.innerHTML = country['surname'];
            selectCountry1.appendChild(newOption);
        }
        updateBadge(0,data.length);
        updateBadge(4,data.length);
        $('.selectpicker').selectpicker('refresh');
        setOnSelectHandler();
        setOnClickForClearAllButtons();
        initControlsArray();
    }
});*/

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
            if (controlsArray[i][j]/*.getAttribute('id')*/ === control/*.id*/){
                tabIndex = i;
                selectIndex = j;
            }
        }
    }
    if (controlsArray[tabIndex][selectIndex+1]) {

        for (let i = selectIndex+1; i < controlsArray[tabIndex].length; i++) {
            clearSelectBox(controlsArray[tabIndex][i]);
            $(controlsArray[tabIndex][i]).selectpicker('refresh');
        }
        let prKey = $(control).val();
        dataOrganizer.getDataById(controlsArray[tabIndex][selectIndex+1], prKey);
        $(controlsArray[tabIndex][selectIndex+1]).prop('disabled', false);
        $(controlsArray[tabIndex][selectIndex+1]).selectpicker('refresh');
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

class DataOrganizer {
    getData(controlToLoad, index) {
        switch (index) {
            case 0: this._getCountries(controlToLoad);
                break;
            case 1: this._getLeagues(controlToLoad);
                break;
            case 2: this._getTeams(controlToLoad);
                break;
            case 3: this._getPlayers(controlToLoad);
                break;
        }

    }
    getDataById(controlToLoad, id) {
        let type = null;
        for (let i = 0; i < controlsArray.length; i++) {
            for (let j = 0; j < controlsArray[i].length; j++) {
                if (controlsArray[i][j] === controlToLoad){
                    type = controlToLoad.classList[1];
                }
            }
        }
        switch (type) {
            case 'league': this._getLeaguesByCountry(controlToLoad, id);
                break;
            case 'team': this._getTeamsByLeague(controlToLoad, id);
                break;
            case 'player': this._getPlayersByTeam(controlToLoad, id);
                break;
        }
    }

    _getCountries(controlToLoad) {
        $.ajax({
            url: '/country',
            method: 'GET',
            success: function (data) {
                for (let country of data) {
                    let newOption = document.createElement('option');
                    newOption.setAttribute('value', country['id']);
                    newOption.innerHTML = country['name'];
                    controlToLoad.appendChild(newOption);
                }
                $(controlToLoad).selectpicker('refresh');
                updateBadge(controlToLoad, data.length);
            }
        });
    }
    _getLeagues(controlToLoad) {
        $.ajax({
            url: '/league',
            method: 'GET',
            success: function (data) {
                for (let league of data) {
                    let newOption = document.createElement('option');
                    newOption.setAttribute('value', league['id']);
                    newOption.innerHTML = league['name'];
                    controlToLoad.appendChild(newOption);
                }
                $(controlToLoad).selectpicker('refresh');
                updateBadge(controlToLoad, data.length);
            }
        });
    }
    _getTeams(controlToLoad) {
        $.ajax({
            url: '/team',
            method: 'GET',
            success: function (data) {
                for (let team of data) {
                    let newOption = document.createElement('option');
                    newOption.setAttribute('value', team['id']);
                    newOption.innerHTML = team['name'];
                    controlToLoad.appendChild(newOption);
                }
                $(controlToLoad).selectpicker('refresh');
                updateBadge(controlToLoad, data.length);
            }
        });
    }
    _getPlayers(controlToLoad) {
        $.ajax({
            url: '/player',
            method: 'GET',
            success: function (data) {
                for (let player of data) {
                    let newOption = document.createElement('option');
                    newOption.setAttribute('value', player['id']);
                    newOption.innerHTML = player['name'] + " " + player['surname'];
                    controlToLoad.appendChild(newOption);
                }
                $(controlToLoad).selectpicker('refresh');
                updateBadge(controlToLoad, data.length);
            }
        });
    }

    _getLeaguesByCountry(controlToLoad, countryId){
        $.ajax({
            url: '/country/' + countryId +'/league',
            method: 'GET',
            success: function (data) {
                for (let league of data) {
                    let newOption = document.createElement('option');
                    newOption.setAttribute('value', league['id']);
                    newOption.innerHTML = league['name'];
                    controlToLoad.appendChild(newOption);
                }
                $(controlToLoad).selectpicker('refresh');
                updateBadge(controlToLoad, data.length);
            }
        });
    }
    _getTeamsByLeague(controlToLoad, leagueId){
        $.ajax({
            url: '/league/' + leagueId +'/team',
            method: 'GET',
            success: function (data) {
                for (let team of data) {
                    let newOption = document.createElement('option');
                    newOption.setAttribute('value', team['id']);
                    newOption.innerHTML = team['name'];
                    controlToLoad.appendChild(newOption);
                }
                $(controlToLoad).selectpicker('refresh');
                updateBadge(controlToLoad, data.length);
            }
        });
    }
    _getPlayersByTeam(controlToLoad, playerId){
        $.ajax({
            url: '/team/' + playerId +'/player',
            method: 'GET',
            success: function (data) {
                for (let player of data) {
                    let newOption = document.createElement('option');
                    newOption.setAttribute('value', player['id']);
                    newOption.innerHTML = player['name'] + " " + player['surname'];
                    controlToLoad.appendChild(newOption);
                }
                $(controlToLoad).selectpicker('refresh');
                updateBadge(controlToLoad, data.length);
            }
        });
    }
}