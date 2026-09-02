#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <map>
#include <set>
#define ll long long int
using namespace std;

void solve() {
    int R; cin>>R;
    map<int, vector<pair<int, int>>> g;
    set<int> vis;
    while (R--) {
        int src, dest, dist; cin>>src>>dest>>dist;
        g[src].push_back(make_pair(dest, dist));
        g[dest].push_back(make_pair(src, dist));
    }
    int st, end; cin>>st>>end;
    priority_queue<pair<int, int>, 
    vector<pair<int, int>>, 
    greater<pair<int, int>>> pq;
    pq.push(make_pair(0, st));

    while (!pq.empty()) {
        auto[currdist, city] = pq.top(); pq.pop();
        if (!vis.contains(city)) {
            vis.insert(city);
            if (city == end) {
                cout<<currdist; return;
            }
            for (auto[oc, ocd] : g[city]) {
                if (!vis.contains(oc)) {
                    pq.push(make_pair(currdist+ocd, oc));
                }
            }
        }
    }
    cout<<"City "<<end<<" Cannot be reached"<<endl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int tc = 1;
    while(tc--) {
        solve();
    }
}
