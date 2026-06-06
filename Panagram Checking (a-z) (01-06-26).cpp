#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main() {
    string str;
    getline(cin, str);
    int flag = 0;
    for (char ch : str) {
        ch = tolower(ch);
        if (ch >= 'a' && ch <= 'z') {
            flag |= (1 << (ch - 'a'));
        }
    }
    if (flag == (1 << 26) - 1)
        cout << "Pangram";
    else
        cout << "Not Pangram";
    return 0;
}