#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    int L = s.length();
    for (int ctr = 1; ctr < (1 << L); ctr++) {
        string combi = "";
        for (int sh = 0; sh < L; sh++) {
            if ((ctr & (1 << sh)) > 0) {
                combi += s[sh];
            }
        }
        cout << combi << endl;
    }
    return 0;
}