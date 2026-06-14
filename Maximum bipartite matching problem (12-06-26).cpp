#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void solve() {
    int M, N;
    cin >> M >> N;

    vector<int> a(M), b(N);

    for (int i = 0; i < M; i++) {
        cin >> a[i];
    }

    for (int i = 0; i < N; i++) {
        cin >> b[i];
    }

    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    int count = 0;
    int ai = M - 1;
    int bi = N - 1;

    while (ai >= 0 && bi >= 0) {
        if (b[bi] <= a[ai] * 2) {
            count++;
            ai--;
            bi--;
        } else {
            bi--;
        }
    }

    cout << count;
}

int main() {
    solve();
    return 0;
}