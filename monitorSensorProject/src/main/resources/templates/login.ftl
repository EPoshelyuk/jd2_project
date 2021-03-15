<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>

    <title>Login</title>
    <#include "style/login_form.ftl">
</head>
<body>

<div class="container d-flex align-items-center">
    <div class="row main-form d-flex align-items-center">
        <form class="" method="post" action="/login">
            <h1 class="text-center">Sign in</h1>

            <div class="form-group d-flex align-items-center">
                <label for="name" class>Your login:</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" name="username" id="name" placeholder="Enter your Login"
                           required/>
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="cols-sm-2 control-label">Your password</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                    <input type="password" class="form-control" name="password" id="password"
                           placeholder="Enter your Password" required/>
                    <div class="input-group-addon" id="s-h-pass"><span class="glyphicon glyphicon-eye-open"
                                                                       title="Show password"></span></div>
                </div>
            </div>

            <div class="form-row text-center">
                    <button type="submit" class="btn btn-outline-info btn-rounded"
                            data-mdb-ripple-color="dark" style="color: #4682B4">Login
                    </button>
                    <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
            </div>
        </form>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#s-h-pass').click(function () {
            var type = $('#password').attr('type') == "text" ? "password" : 'text',
                c = $(this).html() == "<span class=\"glyphicon glyphicon-eye-close\" title=\"Hide password\"></span>" ? "<span class=\"glyphicon glyphicon-eye-open\" title=\"Show password\"></span>" : "<span class=\"glyphicon glyphicon-eye-close\" title=\"Hide password\"></span>";
            $(this).html(c);
            $('#password').prop('type', type);
        });
    });
</script>
</body>
</html>

