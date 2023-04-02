<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>OOP in PHP</title>
        <?php include("class_lib.php"); ?>        
    </head>
    <body>
        <?php
            $stefan = new Person();
            $jimmy = new Person();

            $stefan->set_name("Stefan Mischook");
            $jimmy->set_name("Nick Waddles");

            echo "Stefan's full name: " . $stefan->get_name();
            echo "Jimmy's full name: " . $jimmy->get_name();
        ?>
    </body>
</html>