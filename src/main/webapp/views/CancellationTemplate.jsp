<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cancellation-Template</title>
    <style>
        body{
            display: block;
            margin: 10px;
        }
        .container {
            width: 100%;
        }

        .card {
            margin: 20px 0px 20px 0px;
            padding: 25px 25px 25px 25px;
            background-color: rgb(245, 246, 247);
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            transition: 0.3s;
        }


    </style>
</head>
<body>
<div class="container">
    <div style="width: 100%">
        <div style=" margin-top: 20px; display: flex; justify-content: center">
            <img
                    src="data:image/jpeg;base64,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"
                    alt="Beehyv Logo"
                    height="50px"
                    width="150px"
            />
        </div>
        <div class="card">
            <p>Hi ,</p>
            <p>
                ${Employee_Name} has cancelled their leave request  from ${start_date} to ${end_date}
            </p>
            <p>Comments :  ${comments}</p>

            <p>Thank you for your time and consideration.</p>
            <p>Best regards</p>

            <div style="margin-top: 30px;">
                <i style="font-size:14px ;">You are receiving this email from Beesheets:  </i>
                <a style="font-size:14px ;"
                   href="#"
                >View it on Beesheets</a
                >
            </div>
        </div>
    </div>
</div>
</body>
</html>