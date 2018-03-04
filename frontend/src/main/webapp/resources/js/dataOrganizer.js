let dataOrganizer;
let cacheObject = {
    countries:[],
    leagues:[],
    teams:[],
    players:[],
    coaches:[]
};
class DataOrganizer {
    isCorrectFields(obj, type) {
        for (let field in obj) {
            if (obj[field] === "" || obj[field] === null) {
                return false;
            }
        }
        let dataToCompare;
        if (type === "players" || type === "coaches") {
            dataToCompare = obj["name"] + obj["surname"];
        } else {
            dataToCompare = obj["name"];
        }
        for (let field of cacheObject[type]) {
            if (field.trim().toLowerCase() === dataToCompare.trim().toLowerCase()) {
                return false;
            }
        }
        return true;
    }
    addData(index) {
        let modal = document.getElementsByClassName('modal')[index];
        switch (+index) {
            case 0: this._addCountry(modal, index);
                break;
            case 1: this._addLeague(modal, index);
                break;
            case 2: this._addTeam(modal, index);
                break;
            case 3: this._addPlayer(modal, index);
                break;
            case 4: this._addCoach(modal, index);
                break;
        }
    }

    _addCountry(modal, index) {
        let input = modal.getElementsByTagName('input')[0];
        let obj = new Object();
        obj.name = input.value;
        if (this.isCorrectFields(obj, "countries")) {
            let json = JSON.stringify(obj);
            $.ajax({
                type: "PUT",
                contentType: "application/json; charset=UTF-8",
                url: "/country",
                data: json,
                success: function (data) {
                    let tab = document.getElementsByClassName('tab')[index];
                    let event = new Event('click');
                    tab.dispatchEvent(event);
                }
            })
        } else {
            alert('You have empty fields! Check it.')
        }

    }
    _addLeague(modal, index) {
        let prKey = $(controlsArray[index][0]).val();
        let input = modal.getElementsByTagName('input')[0];
        let obj = new Object();
        obj.name = input.value;
        obj.countryId = prKey;
        if (this.isCorrectFields(obj, "leagues")) {
            let json = JSON.stringify(obj);
            $.ajax({
                type: "PUT",
                contentType: "application/json; charset=UTF-8",
                url: "/league",
                data: json,
                success: function (data) {
                    clearTable(+index);
                    dataOrganizer.appendTable(+index, prKey);
                }
            })
        } else {
            alert('You have empty fields! Check it.')
        }

    }
    _addTeam(modal, index) {
        let prKey = $(controlsArray[index][1]).val();
        let input = modal.getElementsByTagName('input')[0];
        let obj = new Object();
        obj.name = input.value;
        obj.leagueId = prKey;
        if (this.isCorrectFields(obj, "teams")) {
            let json = JSON.stringify(obj);
            $.ajax({
                type: "PUT",
                contentType: "application/json; charset=UTF-8",
                url: "/team",
                data: json,
                success: function (data) {
                    clearTable(+index);
                    dataOrganizer.appendTable(+index, prKey);
                }
            })
        } else {
            alert('You have empty fields! Check it.')
        }

    }
    _addPlayer(modal, index) {
        let prKey = $(controlsArray[index][2]).val();
        let obj = new Object();
        obj.name =  modal.getElementsByTagName('input')[0].value;
        obj.surname =  modal.getElementsByTagName('input')[1].value;
        obj.lostMatches =  modal.getElementsByTagName('input')[2].value;
        obj.winMatches =  modal.getElementsByTagName('input')[3].value;
        obj.drawMatches =  modal.getElementsByTagName('input')[4].value;
        obj.goals =  modal.getElementsByTagName('input')[5].value;
        obj.keyPasses =  modal.getElementsByTagName('input')[6].value;
        obj.redCards =  modal.getElementsByTagName('input')[7].value;
        obj.yellowCards =  modal.getElementsByTagName('input')[8].value;
        obj.idTeam = prKey;
        let posSelect = modal.getElementsByTagName('select');
        obj.idPosition = $(posSelect).val();
        if (this.isCorrectFields(obj, "players")) {
            let json = JSON.stringify(obj);
            $.ajax({
                type: "PUT",
                contentType: "application/json; charset=UTF-8",
                url: "/player",
                data: json,
                success: function (data) {
                    clearTable(+index);
                    dataOrganizer.appendTable(+index, prKey);
                }
            })
        } else {
            alert('You have empty fields! Check it.')
        }

    }
    _addCoach(modal, index) {
        let prKey = $(controlsArray[index][2]).val();
        let obj = new Object();
        obj.name =  modal.getElementsByTagName('input')[0].value;
        obj.surname =  modal.getElementsByTagName('input')[1].value;
        obj.lostMatches =  modal.getElementsByTagName('input')[4].value;
        obj.winMatches =  modal.getElementsByTagName('input')[5].value;
        obj.drawMatches =  modal.getElementsByTagName('input')[6].value;
        obj.yearsOld =  modal.getElementsByTagName('input')[2].value;
        obj.titles =  modal.getElementsByTagName('input')[3].value;
        obj.idTeam = prKey;
        if (this.isCorrectFields(obj, "coaches")) {
            let json = JSON.stringify(obj);
            $.ajax({
                type: "PUT",
                contentType: "application/json; charset=UTF-8",
                url: "/coach",
                data: json,
                success: function (data) {
                    clearTable(+index);
                    dataOrganizer.appendTable(+index, prKey);
                }
            })
        } else {
            alert('You have empty fields! Check it.')
        }

    }
    getData(controlToLoad, index, id) {
        switch (index) {
            case 0: this._getCountries(controlToLoad);
                break;
            case 1: this._getLeagues(controlToLoad);
                break;
            case 2: this._getTeams(controlToLoad);
                break;
            case 3: this._getPlayers(controlToLoad);
                break;
            case 4: this._getPlayerStatistic(id);
                break;
            case 5: this._getCoachStatistic(id);
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
    appendTable( tabIndex, prKey) {
        let table = document.getElementsByClassName('info-table')[tabIndex];
        switch (tabIndex) {
            case 0: this._appendCountryTable(table);
                break;
            case 1: this._appendLeagueTable(table, prKey);
                break;
            case 2: this._appendTeamTable(table,prKey);
                break;
            case 3: this._appendPlayerTable(table, prKey);
                break;
            case 4: this._appendCoachTable(table, prKey);
                break;
        }
    }

    _deleteRow(tabIndex, rowIndex, prKey){
        switch (tabIndex) {
            case 0: this._deleteCountry(tabIndex,rowIndex, prKey);
                break;
            case 1: this._deleteLeague(tabIndex,rowIndex, prKey);
                break;
            case 2: this._deleteTeam(tabIndex,rowIndex, prKey);
                break;
            case 3: this._deletePlayer(tabIndex,rowIndex, prKey);
                break;
            case 4: this._deleteCoach(tabIndex,rowIndex, prKey);
                break;
        }
    }

    _deleteCountry(tabIndex, rowIndex, prKey){
        $.ajax({
            url: '/country/' + rowIndex,
            method: 'DELETE',
            success: function (date) {
                let table = document.getElementsByClassName('info-table')[tabIndex];
                let tbody = table.getElementsByTagName('tbody')[0];
                tbody.innerHTML = '';
                dataOrganizer.appendTable(tabIndex, prKey);
            }
        });
    }
    _deleteLeague(tabIndex, rowIndex, prKey){
        $.ajax({
            url: '/league/' + rowIndex,
            method: 'DELETE',
            success: function (date) {
                let table = document.getElementsByClassName('info-table')[tabIndex];
                let tbody = table.getElementsByTagName('tbody')[0];
                tbody.innerHTML = '';
                dataOrganizer.appendTable(tabIndex, prKey);
            }
        });
    }
    _deleteTeam(tabIndex, rowIndex, prKey){
        $.ajax({
            url: '/team/' + rowIndex,
            method: 'DELETE',
            success: function (date) {
                let table = document.getElementsByClassName('info-table')[tabIndex];
                let tbody = table.getElementsByTagName('tbody')[0];
                tbody.innerHTML = '';
                dataOrganizer.appendTable(tabIndex, prKey);
            }
        });
    }
    _deletePlayer(tabIndex, rowIndex, prKey){
        $.ajax({
            url: '/player/' + rowIndex,
            method: 'DELETE',
            success: function (date) {
                let table = document.getElementsByClassName('info-table')[tabIndex];
                let tbody = table.getElementsByTagName('tbody')[0];
                tbody.innerHTML = '';
                dataOrganizer.appendTable(tabIndex, prKey);
            }
        });
    }
    _deleteCoach(tabIndex, rowIndex, prKey){
        $.ajax({
            url: '/coach/' + rowIndex,
            method: 'DELETE',
            success: function (date) {
                let table = document.getElementsByClassName('info-table')[tabIndex];
                let tbody = table.getElementsByTagName('tbody')[0];
                tbody.innerHTML = '';
                dataOrganizer.appendTable(tabIndex, prKey);
            }
        });
    }
    _appendCountryTable(table) {
        $.ajax({
            url: '/country',
            method: 'GET',
            success: function (data) {
                cacheObject.countries = [];
                let tbody = table.getElementsByTagName('tbody')[0];
                for (let elem of data) {
                    cacheObject.countries.push(elem["name"]);
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    let td = document.createElement('td');
                    td.innerHTML = elem['name'];
                    tr.appendChild(th);
                    tr.appendChild(td);
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\">Delete</button>";
                    delBut.addEventListener('click', function(event) {
                        let curButton = event.currentTarget;
                        let id = curButton.parentNode.firstChild.outerText;
                        dataOrganizer._deleteRow(0,id);
                    });

                    tr.appendChild(delBut);
                    tbody.appendChild(tr);
                }
            }
        });
    }
    _appendLeagueTable(table, prKey) {
        $.ajax({
            url: '/country/'+ prKey +'/league',
            method: 'GET',
            success: function (data) {
                cacheObject.leagues = [];
                let tbody = table.getElementsByTagName('tbody')[0];
                // if (!data.length) {
                //     let tmp = data;
                //     data = [];
                //     data.push(tmp);
                // }
                for (let elem of data) {
                    cacheObject.leagues.push(elem["name"]);
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    let td = document.createElement('td');
                    td.innerHTML = elem['name'];
                    tr.appendChild(th);
                    tr.appendChild(td);
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" prKey=\""+prKey+"\">Delete</button>";
                    delBut.addEventListener('click', function(event) {
                        let curButton = event.currentTarget;
                        let id = curButton.parentNode.firstChild.outerText;
                        let prKey = curButton.firstChild.getAttribute('prKey');
                        dataOrganizer._deleteRow(1,id,prKey);
                    });
                    tr.appendChild(delBut);
                    tbody.appendChild(tr);
                }
            }
        });
    }
    _appendTeamTable(table, prKey) {
        $.ajax({
            url: "/league/"+prKey+"/team",
            method: 'GET',
            success: function (data) {
                cacheObject.teams = [];
                let tbody = table.getElementsByTagName('tbody')[0];
                for (let elem of data) {
                    cacheObject.teams.push(elem["name"]);
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    let td = document.createElement('td');
                    td.innerHTML = elem['name'];
                    tr.appendChild(th);
                    tr.appendChild(td);
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" prKey=\""+prKey+"\">Delete</button>";
                    delBut.addEventListener('click', function(event) {
                        let curButton = event.currentTarget;
                        let id = curButton.parentNode.firstChild.outerText;
                        let prKey = curButton.firstChild.getAttribute('prKey');
                        dataOrganizer._deleteRow(2,id, prKey);
                    });
                    tr.appendChild(delBut);
                    tbody.appendChild(tr);
                }
            }
        });
    }
    _appendPlayerTable(table, prKey) {
        $.ajax({
            url: "/team/"+prKey+"/player",
        method: 'GET',
            success: function (data) {
                cacheObject.players = [];
                let tbody = table.getElementsByTagName('tbody')[0];
                for (let elem of data) {
                    cacheObject.players.push(elem["name"]+elem["surname"]);
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    tr.appendChild(th);
                    for (let prop in elem) {
                        if (prop !== 'idStatistic' && prop !== 'id') {
                            let td = document.createElement('td');
                            td.innerHTML = elem[prop];
                            tr.appendChild(td);
                        }
                    }
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" prKey=\""+prKey+"\">Delete</button>";
                    delBut.addEventListener('click', function(event) {
                        let curButton = event.currentTarget;
                        let id = curButton.parentNode.firstChild.outerText;
                        let prKey = curButton.firstChild.getAttribute('prKey');
                        dataOrganizer._deleteRow(3,id, prKey);
                    });
                    tr.appendChild(delBut);
                    tbody.appendChild(tr);
                }
            }
        });
    }
    _appendCoachTable(table, prKey){
        $.ajax({
            url: "/team/"+prKey+"/coach",
            method: 'GET',
            success: function (data) {
                let tbody = table.getElementsByTagName('tbody')[0];
                cacheObject.coaches = [];
                for (let elem of data) {
                    cacheObject.coaches.push(elem["name"]+elem["surname"]);
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    tr.appendChild(th);
                    for (let prop in elem) {
                        if (prop !== 'idStatistic' && prop !== 'id') {
                            let td = document.createElement('td');
                            td.innerHTML = elem[prop];
                            tr.appendChild(td);
                        }
                    }
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" prKey=\""+prKey+"\">Delete</button>";
                    delBut.addEventListener('click', function(event) {
                        let curButton = event.currentTarget;
                        let id = curButton.parentNode.firstChild.outerText;
                        let prKey = curButton.firstChild.getAttribute('prKey');
                        dataOrganizer._deleteRow(4,id, prKey);
                    });
                    tr.appendChild(delBut);
                    tbody.appendChild(tr);
                }
            }
        });
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

    _getPlayerStatistic(playerId){
        $.ajax({
            url: '/player/' + playerId,
            method: 'GET',
            success: function (data) {
                for (let prop in data) {
                    if (prop !== 'id' && prop !== 'idStatistic' && prop !== 'surname') {
                        if (prop === 'name') {
                            document.getElementsByClassName(prop)[0].innerHTML = (data[prop] + ' ' + data['surname']).toUpperCase();
                        } else {
                            document.getElementsByClassName(prop)[0].innerHTML = data[prop];
                        }
                    }
                }
            }
        });
    }
    _getCoachStatistic(coachId){
        $.ajax({
            url: '/team/' +coachId + '/coach',
            method: 'GET',
            success: function (data) {
                data = data[0];
                for (let prop in data) {
                    let index;
                    switch (prop) {
                        case 'name': index = 1; break;
                        case 'drawMatches': index = 1; break;
                        case 'winMatches': index = 1; break;
                        case 'lostMatches': index = 1; break;
                        default: index = 0;
                    }
                    if (prop !== 'id' && prop !== 'idStatistic' && prop !== 'surname') {
                        if (prop === 'name') {
                            document.getElementsByClassName(prop)[index].innerHTML = (data[prop] + ' ' + data['surname']).toUpperCase();
                        } else {
                            document.getElementsByClassName(prop)[index].innerHTML = data[prop];
                        }
                    }
                }
            }
        });
    }

    getPositions() {
        $.ajax({
            url: '/position',
            method: 'GET',
            success: function (data) {
                let modal = document.getElementsByClassName('modal')[3];
                let selectControl = modal.getElementsByTagName('select')[0];
                for (let pos of data) {
                    let newOption = document.createElement('option');
                    newOption.setAttribute('value', pos['id']);
                    newOption.innerHTML = pos['name'];
                    selectControl.appendChild(newOption);
                }
                $(selectControl).selectpicker('refresh');
            }
        });
    }
}