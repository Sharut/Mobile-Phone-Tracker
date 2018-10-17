# Mobile-Phone-Tracker
Designed a data structure to help create a simplified version of the mobile phone tracking system.
Used sets and linked lists as data strctures to implement the Mobile Tracker.

Here is a short description about the classes and their methods used. 
# Class Mobile Phone implements the following methods:
– MobilePhone(Int number): constructor to create a mobile phone.  Unique identifier for a mobile phone is an integer. 

– public Int number(): returns the id of the mobile phone.

– public Boolean status(): returns the status of the phone, i.e. switched on or switched off.

– public void switchOn(): Changes the status to switched on.

– public void switchOff(): Changes the status to switched off.

– public Exchange location(): returns the base station with which the phone is registered if the phone is switched on and an excep- tion if the phone is off. The class Exchange will be described next.

# Class MobilePhoneSet stores MobilePhone objects in a Myset.

# Class ExchangeList implements a linked list of exchanges.

# Class Exchange that will form the nodes of the routing map structure implements the following methods:
– Exchange(Int number): constructor to create an exchange. Unique identifier for an exchange is an integer.

– All usual Node methods for a general tree like public Exchange parent(), public Exchange numChildren()(for number of children), public Exchange child(int i) (returns the ith child), public Boolean isRoot(), public RoutingMapTree subtree(int i) (returns the ith subtree) and any other tree methods you need. The class definition RoutingMapTree will be defined later.

– public MobilePhoneSet residentSet(): This returns the resident set of mobile phones of the exchange.

# Class RoutingMapTree that will form the nodes of the routing map structure implements the following methods:
– RoutingMapTree(): constructor method. This should create a RoutingMapTree with one Exchange node, the root node which has an identifier of 0. Create other constructors that you deem necessary.

– All general tree methods like public Boolean containsNode(Exchange a) but with Exchange as the node class.

– public void switchOn(MobilePhone a, Exchange b): This method only works on mobile phones that are currently switched off. It switches the phone a on and registers it with base station b. The entire routing map tree will be updated accordingly.

– public void switchOff(MobilePhone a): This method only works on mobile phones that are currently switched on. It switches the phone a off. The entire routing map tree has to be updated ac- cordingly.

– public void performAction(String actionMessage): This the main stub method that you have to implement. It takes an action as a string. The list of actions, and their format will be described next.

# The following query messages are answered by our tracker:

• addExchange a b This should create a new Exchange b, and add it to the child list of Exchange a. If node a has n children, b should be its (n + 1)th child. If there is no Exchange with identifier a, then throw an Exception.

• switchOnMobile a b This should switch ON the mobile phone a at Exchange b. If the mobile did not exist earlier, create a new mobile phone with identifier a. If there is no Exchange with an identifier b, throw an exception.

• switchOffMobile a This should switch OFF the mobile phone a. If there is no mobile phone with identifier a, then throw an Exception.

• queryNthChild a b This should print the identifier of the Exchange which is the (b)th child of Exchange a.

• queryMobilePhoneSet a This should print the identifier of all the mo- bile phones which are part of the resident set of the Exchange with identifier a.



