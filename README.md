<h1>Cruise Ship Boarding Cabin Booking</h1>
<h2>Problem Description</h2>
    <p>
      The goal of this project is to design a system for managing cabin bookings
      on a cruise ship boarding. The cruise ship has a fixed number of cabins,
      and passengers can book cabins based on their preferences and
      availability.
    </p>
    <h2>Solution 1: Array-Based Solution </h2>
    <p>
      The first solution is implemented using arrays to represent the cabins on
      the cruise ship. Each element in the array corresponds to a cabin, and the
      value of the element indicates its availability status (e.g., vacant or
      occupied). The array-based solution provides the following features:
    </p>
    <ul>
      <li>
        Cabin Booking: Passengers can search for available cabins based on their
        preferences (e.g., cabin type, location, capacity) and book a cabin if
        it meets their requirements.
      </li>
      <li>
        Cabin Release: Passengers can release a booked cabin if they decide to
        cancel their booking.
      </li>
      <li>
        Availability Check: The system can check the availability of a specific
        cabin based on its cabin number or other criteria.
      </li>
    </ul>
    <p>
      To use the array-based solution, you need to instantiate an array
      representing the cabins and utilize the provided methods to interact with
      the booking system.
    </p>
    <h2>Solution 2: <a href="https://github.com/LuciferDIot/CRUISE-SHIP-BOARDING-Class-Solution.git">Class-Based Solution with Circular Queue</a> </h2>
    <p>
      The second solution is implemented using classes to model the cabins and
      manage the booking process. The class-based solution utilizes a circular
      queue data structure to handle the cabin booking efficiently. The features
      offered by the class-based solution include:
    </p>
    <ul>
      <li>
        Cabin Class: Each cabin is represented by an instance of a Cabin class,
        which contains attributes such as cabin number, type, location,
        capacity, and availability status.
      </li>
      <li>
        Booking System: The BookingSystem class manages the collection of cabins
        and utilizes a circular queue data structure to handle the cabin
        booking. The circular queue ensures efficient utilization of cabins and
        simplifies the cabin allocation process.
      </li>
      <li>
        Cabin Booking: Passengers can search for available cabins based on their
        preferences (e.g., cabin type, location, capacity) and book a cabin if
        it meets their requirements. The circular queue algorithm ensures that
        cabins are allocated in a fair and efficient manner.
      </li>
      <li>
        Cabin Release: Passengers can release a booked cabin if they decide to
        cancel their booking. The circular queue algorithm adjusts the queue
        accordingly to fill any empty cabins and maintain fairness in cabin
        allocation.
      </li>
      <li>
        Availability Check: The system can check the availability of a specific
        cabin based on its cabin number or other criteria. The circular queue
        algorithm efficiently searches for the desired cabin by traversing the
        queue.
      </li>
    </ul>
    <p>
      To use the class-based solution with circular queue, you need to create
      instances of the Cabin and BookingSystem classes and utilize the provided
      methods to interact with the booking system.
    </p>
    <h2>Getting Started</h2>
    <p>To use the provided solutions, follow these steps:</p>
    <ol>
      <li>Clone the repository or download the source code.</li>
      <li>
        Import the project into your preferred Java development environment.
      </li>
      <li>Compile and run the code to test the solutions.</li>
      <li>
        Modify the code as per your requirements or integrate it into your
        existing project.
      </li>
    </ol>
    <h2>Example Usage</h2>
    <p>
      To give you an idea of how to use the solutions, here's an example usage
      scenario:
    </p>
    <pre><code>
// Array-Based Solution
CabinBookingSystem cabinBookingSystem = new CabinBookingSystem(100);  // Instantiate the booking system with 100 cabins
cabinBookingSystem.bookCabin("John Doe", CabinType.DELUXE, 2);  // Book a deluxe cabin for 2 passengers
cabinBookingSystem.releaseCabin("John Doe");  // Release the cabin booked by John Doe

// Class-Based Solution with Circular Queue
BookingSystem bookingSystem = new BookingSystem(100);  // Instantiate the booking system with 100 cabins
bookingSystem.bookCabin("John Doe", CabinType.DELUXE, 2);  // Book a deluxe cabin for 2 passengers
bookingSystem.releaseCabin("John Doe");  // Release the cabin booked by John Doe
    </code></pre>
    <p>
      Additionally, for the class-based solution with the circular queue, the
      booking process will involve the following steps:
    </p>
    <ol>
      <li>
        Print all empty cabins and ask the customer to choose a cabin from the
        available options.
      </li>
      <li>
        Once the customer selects a cabin, prompt them to enter their first
        name, last name, and expenses.
      </li>
      <li>Add the customer to the selected cabin.</li>
      <li>
        When deleting a customer from a cabin, prompt for the customer's name
        and remove them from the respective cabin.
      </li>
    </ol>
    <h2>License</h2>
    <p>This project is licensed under the <a href="LICENSE">MIT License</a>.</p>
    <p>
      Feel free to modify and adapt the solutions according to your specific
      requirements.
    </p>
    <h2>Contributing</h2>
    <p>
      If you would like to contribute to this project, please follow the
      guidelines outlined in <a href="CONTRIBUTING.md">CONTRIBUTING.md</a>.
    </p>
    <p>
      I hope this provides a clearer understanding of how to use the solutions.
      Let me know if you have any further questions!
    </p>
