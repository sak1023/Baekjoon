#include <iostream>

using namespace std;

int main()
{
    double a, b;
    cin >> a >> b;
    cout << fixed;
    cout.precision(16);
    cout << a / b;
}