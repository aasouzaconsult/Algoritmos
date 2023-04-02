<?php

include_once("EmployeeFactory.php");

class CallCenter {
    private $employees;
    private $allocator;
    private $employeeFactory;

    public function __construct() {
        $this->employeeFactory = new EmployeeFactory();
        $this->employees = [];
        $this->employees[EmployeeFactory::RESPONDENT] = [];
        $this->employees[EmployeeFactory::MANAGER] = [];
        $this->employees[EmployeeFactory::DIRECTOR] = [];

        $this->allocator = new Allocator();
    }

    public function addEmployee($name, $title) {
        $employee = $this->employeeFactory->buildEmployee($name, $title);
        if ($employee) {
            $this->employees[$title][] = $employee;
            return True;
        }
        return False;
    }

    public function handle(Call $call) {
        if ($call->getCaller()) {
            $employee = $this->allocator->handle($call, $this->employees);
            if ($employee) {
                echo $employee->getname() . " is handling your call. Hold on..." . PHP_EOL;
            } else {
                echo "Our operators are all busy at the moment. Please call again." . PHP_EOL;
            }
            return True;
        } else {
            echo "Call from " . $call->getCaller() . " rejected." . PHP_EOL;
            return False;
        }
    }
}