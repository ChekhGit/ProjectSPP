<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
<head>
    <title>Soccer</title>

    <link rel="stylesheet" href="../resources/css/bootstrap.css">
    <script type="text/javascript" src="../resources/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
    
    <!-- select styles -->
    <link rel="stylesheet" href="../resources/bootstrap-select/css/bootstrap-select.min.css">
    <script src="../resources/bootstrap-select/js/bootstrap-select.min.js"></script>
    
    <link rel="stylesheet" href="../resources/styles/tabs.css">
    <link rel="stylesheet" href="../resources/styles/dropDownList.css">

    <script src="../resources/js/statistic.js"></script>
    <style>
        .clear {
            margin-top: 20px;
            width: 40%;
        }
        body {
            overflow-x:hidden;
        }
        .name {
            text-align: center;
            font-size: larger;
        }
        .info {
            text-align: center;
        }
        .info > .row .label{
font-size: smaller;
        }
    </style>
</head>
<body >
     <div class="tabs">
        <div class="tab-2">
            <label for="tab2-1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Player statistic</label>
            <input id="tab2-1" name="tabs-two" type="radio" checked="checked">
            <div>
            <div class="container" id="select-container">
                <div class="col-lg-4">
                <div class="row">
                        <h3><span class="label">Country <span class="badge"></span></span></h3>
                        <select class="selectpicker country" data-size="5" id="country">
                            <option></option>
                        </select>
                </div>
                <div class="row">
                        <h3><span class="label">League <span class="badge"></span></span></h3>
                        <select class="selectpicker league" data-size="5" id="league" disabled>
                            <option></option>
                        </select>
                </div>
                <div class="row">
                        <h3><span class="label">Team <span class="badge"></span></span></h3>
                        <select class="selectpicker team" data-size="5" id="team" disabled>
                            <option></option>
                        </select>
                </div>
                <div class="row">
                        <h3><span class="label">Player <span class="badge"></span></span></h3>
                        <select class="selectpicker player" data-size="5" id="player" disabled>
                            <option></option>
                        </select>
                </div>
                <div class="row">
                        <button class="btn btn-info btn-md clear" tab-numb="0">Clear all</button>
                </div>
            </div>
                <div class="col-lg-offset-2 col-lg-6 info">
                    <h1><span class="label name">DAVID VILLA</span></h1>
                    <div class="row">
                        <div class="col-md-6">
                            <h3><span class="label pos">Position: GK</span></h3>
                        </div>
                        <div class="col-md-6">
                            <h3><span class="label ">Goals: 320</span></h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h3><span class="label ">Wins: 20</span></h3>
                        </div>
                        <div class="col-md-6">
                            <h3><span class="label ">Passes: 111</span></h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h3><span class="label ">Loses: 51</span></h3>
                        </div>
                        <div class="col-md-6">
                            <h3><span class="label ">Red cards: 2</span></h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h3><span class="label ">Draws: 30</span></h3>
                        </div>
                        <div class="col-md-6">
                            <h3><span class="label ">Yellow cards: 12</span></h3>
                        </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
        <div class="tab-2">

            <label for="tab2-2"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> Coach statistic</label>
            <input id="tab2-2" name="tabs-two" type="radio">
            <div>
                <div class="container" >
                <div class="col-lg-4">
                    <div class="row">
                        <h3><span class="label">Country <span class="badge"></span></span></h3>
                        <select class="selectpicker country" data-size="5" id="country-coach">
                            <option></option>
                        </select>
                    </div>
                    <div class="row">
                        <h3><span class="label">League <span class="badge"></span></span></h3>
                        <select class="selectpicker league" data-size="5" id="league-coach" disabled>
                            <option></option>
                        </select>
                    </div>
                    <div class="row">
                        <h3><span class="label">Team <span class="badge"></span></span></h3>
                        <select class="selectpicker team" data-size="5" id="team-coach" disabled>
                            <option></option>
                        </select>
                    </div>
                    <div class="row">
                        <button class="btn btn-info btn-md clear" tab-numb="1">Clear all</button>
                    </div>
                </div>
                <div class="col-lg-offset-2 col-lg-6">
                    <h1 class="name"><span class="label">FERNANDO TORRES</span></h1>

                </div>
            </div>
            </div>
        </div>
    </div>
 </body>
</html>
