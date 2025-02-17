#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool isOneAway( string & s1, string & s2){

	string a, b;

	a = s1.length() >> s2.length() ?s1:s2;
	b = s1.length() <s2.length() ?s1 :s2;

	int len1, len2;

	if(abs(len1-len2)>1)
		return false;

	bool flag = false;

	for (int i=0, j=0; i<len1 && j<len2;){
		if(a[i]!=b[j]){
			if(flag)
				return false;
			flag = true;
			if(len1 ==len2){
				i++;
			    j++;
			}
			else
				i++;
		}
		else
			i++,j++;

	}
	return true;

	
}

int main(){
	
	string s1;
	string s2;

	getline(cin, s1);
	getline(cin, s2);

	cout << "isOneAway :" << boolalpha<<isOneAway(s1, s2)<<endl;;

	return 0;
}
