class Employee(object):
    """

    Common base class for all employees.

    """
    employee_count = 0

    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
        Employee.employee_count += 1

    def display_count(self):
        print "Total Employee %d" % Employee.employee_count

    def display_employee(self):
        print "Name : ", self.name, ", Salary: ", self.salary


class Manager(Employee):
    """

    Manager class sub classes Employee.

    """
    def __init__(self, position):
        self.position = position

    def report_position(self):
        return self.position

if __name__ == "__main__":
    emp1 = Employee('Zara', 2000)
    emp2 = Employee('Manni', 5000)
    emp1.display_employee()
    emp2.display_employee()
    emp1.display_count()
    print getattr(emp1, 'salary')
    print hasattr(emp1, 'name')
    print Employee.__doc__
    print Employee.__name__
    print Employee.__dict__
    print Employee.__bases__
    manager = Manager('vp engineering')
    print manager.report_position()
