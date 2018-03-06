<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Control</title>
    <link rel="stylesheet" href="../resources/css/bootstrap.css">
    <script type="text/javascript" src="../resources/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../resources/bootstrap-select/css/bootstrap-select.min.css">
    <script src="../resources/bootstrap-select/js/bootstrap-select.min.js"></script>

    <link rel="stylesheet" href="../resources/styles/tabs.css">
    <link rel="stylesheet" href="../resources/styles/dropDownList.css">
    <link rel="stylesheet" href="../resources/styles/table.css">

    <script src="../resources/js/dataOrganizer.js"></script>
    <script src="../resources/js/admin.js"></script>
</head>
<body>
<div>
    <ul class="nav nav-tabs" role="tablist">
        <li class="active tab" role="presentation" number="0"><a href="#country" aria-controls="home" role="tab" data-toggle="tab">Countries</a></li>
        <li class="tab" role="presentation" number="1"><a href="#league" aria-controls="profile" role="tab" data-toggle="tab">Leagues</a></li>
        <li class="tab" role="presentation" number="2"><a href="#team" aria-controls="messages" role="tab" data-toggle="tab">Teams</a></li>
        <li class="tab" role="presentation" number="3"><a href="#player" aria-controls="settings" role="tab" data-toggle="tab">Players</a></li>
        <li class="tab" role="presentation" number="4"><a href="#coach" aria-controls="settings" role="tab" data-toggle="tab">Coaches</a></li>
    </ul>

    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="country">
            <div class="tab-2">
                <div class="container" id="select-container">
                    <div class="col-md-3">
                        <div class="row">
                        <button type="button" class="btn btn-danger col-md-offset-2 col-md-8 tab-add" data-toggle="modal" data-target="#countryAddModal" style="margin-top: 30px;">
                            Add
                        </button>
                        </div>
                        <div class="row">
                            <button class="btn btn-info genDoc" onclick="location.href='/team'">Get Document</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-1 col-lg-8 info">
                        <div class="container tbody-box">
                            <table class="table table-dark info-table">
                                <thead><tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Delete</th>
                                </tr></thead>
                                <tbody></tbody></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="league">
            <div class="tab-2">
                <div class="container">
                    <div class="col-md-3">
                        <div class="row">
                            <h3><span class="label">Country <span class="badge"></span></span></h3>
                            <select class="selectpicker country" data-size="5">
                                <option disabled></option>
                            </select>
                        </div>

                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="1">Clear all</button>
                        </div>
                        <div class="row">
                            <button type="button" class="btn btn-danger col-md-8 tab-add" data-toggle="modal" data-target="#leagueAddModal" style="width:40%; margin-top: 30px;" disabled>
                                Add
                            </button>
                        </div>
                        <div class="row">
                            <button class="btn btn-info genDoc" onclick="location.href='/team'" disabled>Get Document</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-1 col-lg-8 info">
                        <div class="container tbody-box">
                            <table class="table table-dark info-table">
                                <thead><tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Delete</th>
                                </tr></thead>
                                <tbody></tbody></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="team">
            <div class="tab-2">
                <div class="container">
                    <div class="col-md-3">
                        <div class="row">
                            <h3><span class="label">Country <span class="badge"></span></span></h3>
                            <select class="selectpicker country" data-size="5">
                                <option disabled></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">League <span class="badge"></span></span></h3>
                            <select class="selectpicker league" data-size="5" disabled>
                                <option disabled></option>
                            </select>
                        </div>
                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="2">Clear all</button>
                        </div>
                        <div class="row">
                            <button type="button" class="btn btn-danger col-md-8 tab-add" data-toggle="modal" data-target="#teamAddModal" style="width:40%; margin-top: 30px;" disabled>
                                Add
                            </button>
                        </div>
                        <div class="row">
                            <button class="btn btn-info genDoc" onclick="location.href='/team'" style="width:40%; margin-top: 30px;" disabled>Get Document</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-1 col-lg-8 info">
                        <div class="container tbody-box">
                            <table class="table table-dark info-table">
                                <thead><tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Delete</th>
                                </tr></thead>
                                <tbody></tbody></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="player">
            <div class="tab-2">
                <div class="container">
                    <div class="col-md-3">
                        <div class="row">
                            <h3><span class="label">Country <span class="badge"></span></span></h3>
                            <select class="selectpicker country" data-size="5">
                                <option disabled></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">League <span class="badge"></span></span></h3>
                            <select class="selectpicker league" data-size="5" disabled>
                                <option disabled></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">Team <span class="badge"></span></span></h3>
                            <select class="selectpicker team" data-size="5" disabled>
                                <option disabled></option>
                            </select>
                        </div>

                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="3">Clear all</button>
                        </div>
                        <div class="row">
                            <button type="button" class="btn btn-danger col-md-8 tab-add" id="openPlayerAddModal" data-toggle="modal" data-target="#playerAddModal" style="width:40%; margin-top: 30px;" disabled>
                                Add
                            </button>
                        </div>
                        <div class="row">
                            <button class="btn btn-info genDoc" onclick="location.href='/team'" style="width:40%; margin-top: 30px;" disabled>Get Document</button>
                        </div>
                    </div>
                    <div class="col-md-9 info">
                        <div class="container tbody-box">
                            <table class="table table-dark info-table">
                                <thead><tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Position</th>
                                    <th>Lost</th>
                                    <th>Wins</th>
                                    <th>Draws</th>
                                    <th>Goals</th>
                                    <th>Passes</th>
                                    <th>Red cards</th>
                                    <th>Yellow cards</th>
                                    <th>Delete</th>
                                </tr></thead>
                                <tbody></tbody></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="coach">
            <div class="tab-2">
                <div class="container">
                    <div class="col-md-3">
                        <div class="row">
                            <h3><span class="label">Country <span class="badge"></span></span></h3>
                            <select class="selectpicker country" data-size="5">
                                <option disabled></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">League <span class="badge"></span></span></h3>
                            <select class="selectpicker league" data-size="5" disabled>
                                <option disabled></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">Team <span class="badge"></span></span></h3>
                            <select class="selectpicker team" data-size="5" disabled>
                                <option disabled></option>
                            </select>
                        </div>
                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="4">Clear all</button>
                        </div>
                        <div class="row">
                            <button type="button" class="btn btn-danger col-md-8 tab-add" data-toggle="modal" data-target="#coachAddModal" style="width:40%; margin-top: 30px;" disabled>
                                Add
                            </button>
                        </div>
                        <div class="row">
                            <button class="btn btn-info genDoc" onclick="location.href='/team'" style="width:40%; margin-top: 30px;" disabled>Get Document</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-1 col-lg-8 info">
                        <div class="container tbody-box">
                            <table class="table table-dark info-table">
                                <thead><tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Years old</th>
                                    <th>Titles</th>
                                    <th>Wins</th>
                                    <th>Lost</th>
                                    <th>Draws</th>
                                    <th>Delete</th>
                                </tr></thead>
                                <tbody></tbody></table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--Add modal windows--%>
    <div class="modal fade" id="countryAddModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add country</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group" id="azaza">
                            <label for="country-name" class="col-form-label">Name:</label>
                            <input type="text" class="form-control" id="country-name"  required>
                        </div>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger add" number="0" data-dismiss="modal">Add</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="leagueAddModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add league</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label for="name" class="col-form-label">Name:</label>
                            <input type="text" class="form-control" id="name">
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger add" number="1" data-dismiss="modal">Add</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="teamAddModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add team</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label class="col-form-label">Name:</label>
                            <input type="text" class="form-control">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger add" number="2" data-dismiss="modal">Add</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="playerAddModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add player</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="row">
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Name:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Surname:</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-offset-1 col-md-9">
                            <label class="col-form-label">Position:</label>
                            <select class="selectpicker position" data-size="5">
                                <option disabled></option>
                            </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-offset-1 col-md-3">
                                <label class="col-form-label">Losts:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-3">
                                <label class="col-form-label">Wins:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-3">
                                <label class="col-form-label">Draws:</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Goals:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Passes:</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Red cards:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Yellow cards:</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger add" number="3" data-dismiss="modal">Add</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="coachAddModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add coach</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="row">
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Name:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Surname:</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Years old:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-offset-1 col-md-4">
                                <label class="col-form-label">Titles:</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-offset-1 col-md-3">
                                <label class="col-form-label">Losts:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-3">
                                <label class="col-form-label">Wins:</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-md-3">
                                <label class="col-form-label">Draws:</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger add" number="4" data-dismiss="modal">Add</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
