let dataOrganizer;

class DataOrganizer {

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
    _getDOMTableElem(value, field){
        let td = document.createElement('td');
        td.innerHTML = value[field];
        return td;
    }
    _appendCountryTable(table) {
        $.ajax({
            url: '/country',
            method: 'GET',
            success: function (data) {
                let tbody = table.getElementsByTagName('tbody')[0];
                for (let elem of data) {
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    let td = document.createElement('td');
                    td.innerHTML = elem['name'];
                    tr.appendChild(th);
                    tr.appendChild(td);
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" tab-numb=\"0\">Delete</button>";
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
                let tbody = table.getElementsByTagName('tbody')[0];
                // if (!data.length) {
                //     let tmp = data;
                //     data = [];
                //     data.push(tmp);
                // }
                for (let elem of data) {
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    let td = document.createElement('td');
                    td.innerHTML = elem['name'];
                    tr.appendChild(th);
                    tr.appendChild(td);
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" tab-numb=\"0\">Delete</button>";
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
                let tbody = table.getElementsByTagName('tbody')[0];
                for (let elem of data) {
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    let td = document.createElement('td');
                    td.innerHTML = elem['name'];
                    tr.appendChild(th);
                    tr.appendChild(td);
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" tab-numb=\"0\">Delete</button>";
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
                let tbody = table.getElementsByTagName('tbody')[0];
                for (let elem of data) {
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    tr.appendChild(th);
                    for (let prop in elem) {
                        if (prop !== 'isStatistic') {
                            let td = document.createElement('td');
                            td.innerHTML = elem[prop];
                            tr.appendChild(td);
                        }
                    }
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" tab-numb=\"0\">Delete</button>";
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
                for (let elem of data) {
                    let tr = document.createElement('tr');
                    let th = document.createElement('th');
                    th.setAttribute('scope','row');
                    th.innerHTML = elem['id'];
                    tr.appendChild(th);
                    for (let prop in elem) {
                        if (prop !== 'isStatistic') {
                            let td = document.createElement('td');
                            td.innerHTML = elem[prop];
                            tr.appendChild(td);
                        }
                    }
                    let delBut = document.createElement('td');
                    delBut.innerHTML = "<button class=\"btn btn-danger btn-md\" tab-numb=\"0\">Delete</button>";
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
            url: '/team/' + playerId +'/statistic',
            method: 'GET',
            success: function (data) {
                document.getElementsByClassName('goals')[0].innerHTML = data['goals'];
            }
        });
    }

}