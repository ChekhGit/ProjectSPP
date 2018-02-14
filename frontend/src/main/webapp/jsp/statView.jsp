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

</head>
<body>
     <div class="tabs">
        <div class="tab-2">
            <label for="tab2-1">Player statistic</label>
            <input id="tab2-1" name="tabs-two" type="radio" checked="checked">
            <div class="container" id="select-container">
                <div class="row">
                    <div class="col-md-4">
                        <select class="selectpicker" data-size="5" id="country-player">
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <select class="selectpicker" data-size="5" id="league-player">
                            <option>AAAAA</option>
                            <option>BBBBB</option>
                            <option>CCCCC</option>
                            <option>DDDDD</option>
                            <option>a</option>
                            <option>v</option>
                            <option>v</option>
                            <option>v</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <select class="selectpicker" data-size="5" id="team-player">
                            <option>AAA</option>
                            <option>BBBBB</option>
                            <option>CCCCC</option>
                            <option>DDDDD</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <select class="selectpicker" data-size="5" id="player-player">
                            <option>AAAAA</option>
                            <option>BBBBB</option>
                            <option>CCCCC</option>
                            <option>DDDDD</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <button class="btn btn-info" id="clear-player" onclick="">Clear all</button>
                </div>
            </div>
        </div>
        <div class="tab-2">
            <label for="tab2-2">Coach statistic</label>
            <input id="tab2-2" name="tabs-two" type="radio">
            <div>

                <h4>Tab Two</h4>
                <p>Quisque sit amet turpis leo. Maecenas sed dolor mi. Pellentesque varius elit in neque ornare commodo ac non tellus. Mauris id iaculis quam. Donec eu felis quam. Morbi tristique lorem eget iaculis consectetur. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean at tellus eget risus tempus ultrices. Nam condimentum nisi enim, scelerisque faucibus lectus sodales at.</p>
            </div>
        </div>
    </div>
 </body>
</html>
