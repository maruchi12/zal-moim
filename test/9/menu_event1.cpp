#include "menu.hpp"

class MenuItem : public BaseMenu
{
	int id;
public:
	MenuItem(string s, int n) : BaseMenu(s), id(n) {}
	
	virtual void command()
	{
		cout << getTitle() << endl;		
	}	
};


int main()
{
	MenuItem m1("Add Student ", 11);
	MenuItem m2("Remove Student ", 12);
	
	m1.command();
	m2.command();
	
	
}
