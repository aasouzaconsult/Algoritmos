<?php

include_once("EmployeeFactory.php");

class Allocator {
    private $sequence;

    public function __construct() {
        $this->sequence = [
            EmployeeFactory::RESPONDENT,
            EmployeeFactory::MANAGER,
            EmployeeFactory::DIRECTOR,
        ];
    }

    public function handle(Call $call, $employees) {
        foreach ($this->sequence as $sequence) {
            foreach ($employees[$sequence] as $employee) {
                if ($employee->isAvailable() && $employee->canHandle()) {
                    $employee->handle($call);
                    return $employee;
                }
            }
        }
        return NULL;
    }
}