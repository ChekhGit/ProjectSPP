<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.02.2018
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Control</title>
    <link rel="stylesheet" href="../resources/css/bootstrap.css">
    <script type="text/javascript" src="../resources/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

    <!-- select styles -->
    <link rel="stylesheet" href="../resources/bootstrap-select/css/bootstrap-select.min.css">
    <script src="../resources/bootstrap-select/js/bootstrap-select.min.js"></script>

    <link rel="stylesheet" href="../resources/styles/tabs.css">
    <link rel="stylesheet" href="../resources/styles/dropDownList.css">
    <style>
        .clear {
            margin-top: 20px;
            width: 40%;
        }
    </style>
</head>
<body>
<div>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#country" aria-controls="home" role="tab" data-toggle="tab">Countries</a></li>
        <li role="presentation"><a href="#league" aria-controls="profile" role="tab" data-toggle="tab">Leagues</a></li>
        <li role="presentation"><a href="#team" aria-controls="messages" role="tab" data-toggle="tab">Teams</a></li>
        <li role="presentation"><a href="#player" aria-controls="settings" role="tab" data-toggle="tab">Players</a></li>
        <li role="presentation"><a href="#coach" aria-controls="settings" role="tab" data-toggle="tab">Coaches</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="country">
            <div class="tab-2">
                <div class="container" id="select-container">
                    <div class="col-md-3">
                        <div class="row">
                            <h3><span class="label">Country <span class="badge"></span></span></h3>
                            <select class="selectpicker country" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="0">Clear all</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-2 col-lg-6 info">
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
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">League <span class="badge"></span></span></h3>
                            <select class="selectpicker league" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="0">Clear all</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-2 col-lg-6 info">
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
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">League <span class="badge"></span></span></h3>
                            <select class="selectpicker league" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">Team <span class="badge"></span></span></h3>
                            <select class="selectpicker team" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="0">Clear all</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-2 col-lg-6 info">
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
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">League <span class="badge"></span></span></h3>
                            <select class="selectpicker league" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">Team <span class="badge"></span></span></h3>
                            <select class="selectpicker team" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">Player <span class="badge"></span></span></h3>
                            <select class="selectpicker player" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="0">Clear all</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-2 col-lg-6 info">
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
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">League <span class="badge"></span></span></h3>
                            <select class="selectpicker league" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">Team <span class="badge"></span></span></h3>
                            <select class="selectpicker team" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <h3><span class="label">Coach <span class="badge"></span></span></h3>
                            <select class="selectpicker coach" data-size="5">
                                <option></option>
                            </select>
                        </div>
                        <div class="row">
                            <button class="btn btn-info btn-md clear" tab-numb="0">Clear all</button>
                        </div>
                    </div>
                    <div class="col-lg-offset-2 col-lg-6 info">
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
