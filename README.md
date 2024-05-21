# Work-Shop-Car-Dealership-2
# Welcome to our Car Dealership we've got the best rates in Town!
Hassan and Julian worked on the workshop together on this workshop, we continued from out last workshop and added a few more options that allowed the users to have the ability to buy/lease vehicles.

We began by using Lucid to plan out what we wanted to do for our project which is in the link below. <br>

[Lucid](https://lucid.app/lucidchart/d114c469-8a4a-4130-8595-7211428f280a/edit?invitationId=inv_9208ffdb-3164-4f04-99a5-bcf5ea6ed96e&page=0_0# "Project planning on Lucid")

We first created three new classes. First of them being an abstract class called Contract this class held all the info that would get us info like current date, customer name, customer email, vehicle sold, total price, and monthly price. After this we made two more classes Sales Contract, and Lease Contract that were both extending from the abstract contract file. Sales class new variables like sales tax, recording fee, processing fee, and finance. We were also able to calculate monthly and total payment by overriding the methods from the parent class. In our Lease Contract class we had new variables like expected ending value, lease fee, lease duration and again calculating the total price and total payment. We also had a Contract File Manager Class where we were able to write code that managed sales and lease contracts by generating and saving data our Contracts CSV file. There are also methods for saving both lease and sale contracts and generating all the necessary data for both of these. <br>

In Our User Interface we were able to add an option for the user to go to buying or leasing a vehicle by typing in "10". Which took us over to our dealership class that prompted the user if they wanted to buy a vehicle, lease a vehicle, or cancel the process. In the dealership class we had functions that allowed user to go through a vehicle buying process using a function called (buyVehicle) inside the customer was asked for all necessary information save it to our CSV file but also calculate the prices of everything for the customer. In our other function called (leaseVehicle) where again we were able to get all information from the customer/user and save it to the Contracts CSV file. When the user finished everything, they would be prompted to the main screen and when they typed "99" our Inventory CSV file would remove the vehicle the customer picked and save that same vehicle as a lease or sale along with all info about the price, and customer information into the Contracts CSV file. 




