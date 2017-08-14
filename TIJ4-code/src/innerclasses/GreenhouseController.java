package innerclasses;

//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
import innerclasses.controller.Event;

public class GreenhouseController {
    public static void main(String[] args) throws InterruptedException {
        GreenhouseControls greenhouseControls = new GreenhouseControls();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        greenhouseControls.addEvent(greenhouseControls.new Bell(900));
        Event[] eventList = { //
                greenhouseControls.new ThermostatNight(0), //
                greenhouseControls.new LightOn(200), //
                greenhouseControls.new LightOff(400), //
                greenhouseControls.new WaterOn(600), //
                greenhouseControls.new WaterOff(800), //
                greenhouseControls.new ThermostatDay(1400) //
        };
        greenhouseControls.addEvent(greenhouseControls.new Restart(2000, eventList));
        //        if (args.length == 1) {
        //            greenhouseControls.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        //        }
        greenhouseControls.run();
    }
} /* Output:
  Bing!
  Thermostat on night setting
  Light is on
  Light is off
  Greenhouse water is on
  Greenhouse water is off
  Thermostat on day setting
  Restarting system
  Terminating
  *///:~
