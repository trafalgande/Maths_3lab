import sys
import matplotlib.pyplot as plt


def plot(args):
    print(args)


if __name__ == '__main__':
    x = []
    y = []
    for i, arg in enumerate(sys.argv):
        if i > 0:
            x.append(int(arg.split(',')[0]))  # x
            y.append(float(arg.split(',')[1]))  # y

    fig, ax = plt.subplots()
    plt.plot(x, y, 'orange', label='main function')
    plt.plot(x, y, '.')

    ax.legend()

    plt.grid(True)
    plt.show()
