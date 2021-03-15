<#ftl output_format="HTML"/>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<#import "parts/searchpager.ftl"as p>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
    <title>Search Result</title>
    <#include "style/main_page_style.ftl">
    <#include "style/search_form_style.ftl">
</head>
<body>

<div class="row">
    <div class="col-sm-10" style="margin-left: 2%"><h1>Search Result</h1></div>
    <div class="col align-self-end">
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
            <button type="submit" class="btn-primary btn-sm but"
                    style=" height:40px;width:150px; margin-right:10%;margin-top:10%; background: #4682B4;border-color: #4682B4 ">
                Sigh out
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                     class="bi bi-door-open-fill" viewBox="0 0 16 16">
                    <path d="M1.5 15a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2.5A1.5 1.5 0 0 0 11.5 1H11V.5a.5.5 0 0 0-.57-.495l-7 1A.5.5 0 0 0 3 1.5V15H1.5zM11 2h.5a.5.5 0 0 1 .5.5V15h-1V2zm-2.5 8c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"/>
                </svg>
            </button>
        </form>
    </div>

</div>
<div class="container">
    <form class="example" action="/allsensors/search">
        <div class="col-md-4">
            <div class="input-group mb-3">
                <input name="searchParam" type="text" class="form-control input-text"
                       placeholder="Search ...." aria-label="Recipient's username"
                       aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <button class="btn btn-outline-warning btn-lg" type="submit"><i class="bi bi-search"></i>
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="col-md-12" style="line-height: 1.5">
    <table class="table table-striped" style="width:80%">
        <thead>
        <tr style=" background: #4d87b8">
            <th scope="col">Name</th>
            <th scope="col">Model</th>
            <th scope="col">Type</th>
            <th scope="col">Range</th>
            <th scope="col">Unit</th>
            <th scope="col">Location</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <#list page.content as sensorDTO>
            <td><a href="/allsensors/update/${sensorDTO.sensorId}" data-toggle="tooltip" data-placement="right"
                   title="${sensorDTO.description}">${sensorDTO.name}</a></td>
            <td>${sensorDTO.model}</td>
            <td>${sensorDTO.type}</td>
            <td>${sensorDTO.rangeFrom}-${sensorDTO.rangeTo}</td>
            <td>${sensorDTO.unit}</td>
            <td>${sensorDTO.location}</td>
            <@security.authorize access="hasAuthority('ADMIN')">
                <td class="minimal_cell">
                    <a href="/allsensors/update/${sensorDTO.sensorId}" title="Edit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="#4682B4"
                             class="bi bi-pencil-fill" viewBox="0 0 16 16">
                            <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                        </svg>
                    </a>
                    &emsp;
                    <a href="/allsensors/delete/${sensorDTO.sensorId}" title="Delete">
                        <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="#B22222"
                             class="bi bi-trash-fill" viewBox="0 0 16 16">
                            <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                        </svg>
                    </a>
                </td>
            </@security.authorize>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
<@p.searchpager url page/>

<form action="/allsensors/back">
    <button type="submit" class="btn btn-primary btn-sm"
            style="height:40px;width:150px; margin-left: 10%;margin-top:10px; background: #4682B4;border-color: #4682B4">
        Back to Sensor table
    </button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
</body>
</html>


